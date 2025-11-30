package br.com.codelift.ecomerce.usecase;

import br.com.codelift.ecomerce.infrastructure.persister.UserEntity;
import br.com.codelift.ecomerce.infrastructure.persister.UserRepositoryH2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateUserTest {
   private static final String EXISTING_USERNAME = "gibson";
   private static final String NAME_TOO_SHORT_MESSAGE = "The name must be 3 or more character";
   private static final String USERNAME_EXISTS_MESSAGE = "Username already exists";

   @Mock
   private UserRepositoryH2 userRepositoryH2;

   @InjectMocks
   private CreateUser createUser;

   @DisplayName("Should throw an error if name less three characters")
   @Test
   void shouldThrowExceptionWhenNameHasLessThanThreeCharacters() throws Exception {
      when(userRepositoryH2.findByLogin("gibson")).thenReturn(Optional.empty());

      Exception e = assertThrows(Exception.class, () ->
              createUser.execute("as", "gibsod", "asdasd", "asdasd"));

      assertEquals(NAME_TOO_SHORT_MESSAGE, e.getMessage());
      verify(userRepositoryH2).findByLogin(EXISTING_USERNAME);
   }

   @DisplayName("Should throw an error if username already exists")
   @Test
   void shouldThrowExceptionWhenUsernameAlreadyExists() {
      UserEntity userEntity = new UserEntity("Gibson", EXISTING_USERNAME, "123");

      when(userRepositoryH2.findByLogin(EXISTING_USERNAME)).thenReturn(Optional.of(userEntity));

      Exception e = assertThrows(Exception.class, () ->
              createUser.execute("Gibson", "gibson", "gibson@gibson", "123"));

      assertEquals(USERNAME_EXISTS_MESSAGE, e.getMessage());
      verify(userRepositoryH2).findByLogin(EXISTING_USERNAME);
   }
}