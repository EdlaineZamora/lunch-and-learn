package br.com.tw.lunchandlearn.infrastructure;

import br.com.tw.lunchandlearn.fixture.UserEntityFixture;
import br.com.tw.lunchandlearn.infrastructure.user.UserEntity;
import br.com.tw.lunchandlearn.infrastructure.user.UserRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void countUsers() {
        long count = userRepository.count();

        assertThat(count, is(0L));
    }

    @Test
    public void createUser() {
        UserEntity user = UserEntityFixture.anUserFixture()
                .build();

        UserEntity userSaved = userRepository.save(user);

        assertThat(userSaved.id, is(not(nullValue())));
    }

    @Test
    public void findUserByName() {
        UserEntity user = UserEntityFixture.anUserFixture()
                .build();

        userRepository.save(user);

        UserEntity userFound = userRepository.findByName("Name");

        assertThat(userFound.id, is(not(nullValue())));
        assertThat(userFound.name, is("Name"));
    }

    @After
    public void tearDown() {
        userRepository.deleteAll();
    }

}