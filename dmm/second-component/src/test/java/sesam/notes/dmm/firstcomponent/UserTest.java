package sesam.notes.dmm.firstcomponent;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class UserTest {

    private User user;

    @Before
    public void init() {
        user = new User();
    }

    @Test
    public void name() throws Exception {
        user.setName("Ivan");
        assertThat(user.getName(), equalTo("Ivan"));
    }

    @Ignore
    @Test
    public void age() throws Exception {
        user.setAge(40);
        assertThat("Fail to verify setup", user.getAge(), equalTo(30));
    }
}
