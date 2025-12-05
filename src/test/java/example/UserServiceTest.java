package example;

import junit.framework.TestCase;
import org.example.EmailSender;
import org.example.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ UserService.class, EmailSender.class })
public class UserServiceTest extends TestCase {
    // 1️⃣ Mock Static Method
    @Test
    public void testStaticMethod() {
        PowerMockito.mockStatic(UserService.class);

        PowerMockito.when(UserService.getSystemToken()).thenReturn("MOCK_TOKEN");

        String token = UserService.getSystemToken();

        assertEquals("MOCK_TOKEN", token);
    }

    // 2️⃣ Mock Final Method
    @Test
    public void testFinalMethod() throws Exception {
        UserService service = PowerMockito.mock(UserService.class);

        when(service.finalCalculation()).thenReturn("MOCK_FINAL");

        assert service.finalCalculation().equals("MOCK_FINAL");
    }
//    // 3️⃣ Mock Private Method
//    @Test
//    public void testPrivateMethod() throws Exception {
//        PaymentService service = PowerMockito.spy(new PaymentService());
//
//        PowerMockito.doReturn("MOCK_KEY")
//                .when(service, "generateSecretKey");
//
//        String result = service.processPayment();
//
//        assert result.contains("MOCK_KEY");
//    }
//
//    // 4️⃣ Mock Constructor Call
//    @Test
//    public void testConstructorMocking() throws Exception {
//        EmailSender mockSender = mock(EmailSender.class);
//        when(mockSender.sendEmail()).thenReturn("MOCK_EMAIL");
//
//        PowerMockito.whenNew(EmailSender.class).withNoArguments().thenReturn(mockSender);
//
//        PaymentService service = new PaymentService();
//
//        String res = service.callEmailSender();
//
//        assert res.equals("MOCK_EMAIL");
//        verify(mockSender).sendEmail();
//    }
}