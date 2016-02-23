package sesam.notes.dmm.firstcomponent;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TransactionTest {

    @InjectMocks
    private Transaction transaction;

    @Mock
    private User user;

    @Test
    public void isChild() throws Exception {
        when(user.getAge()).thenReturn(10);
        assertThat(transaction.isAdult(), equalTo(false));
    }

    @Test
    public void isAdult() throws Exception {
        when(user.getAge()).thenReturn(25);
        assertThat(transaction.isAdult(), equalTo(true));
    }

}
