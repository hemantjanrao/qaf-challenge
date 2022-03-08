package com.ui.framework.listners;

import com.ui.framework.base.BaseUITest;
import org.slf4j.Logger;
import org.testng.*;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class CustomListener implements IInvokedMethodListener {

    protected final Logger log = getLogger(lookup().lookupClass());

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult result) {
        Reporter.setCurrentTestResult(result);
        if (result.getInstance() instanceof BaseUITest) {
            BaseUITest baseTest = (BaseUITest) result.getInstance();
            ITestNGMethod testNgMethod = method.getTestMethod();
            if (result.getStatus() == ITestResult.FAILURE) {
                String methodName = testNgMethod.getMethodName();
                log.debug(String.format("'%s' method is failed, saving screenshot", methodName));
                baseTest.takeScreenShot(methodName);
            }
        }
    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult result) {
    }
}
