import com.ibm.lang.management.internal.ExtendedThreadMXBeanImpl;
import com.sun.management.ThreadMXBean;

import java.lang.management.ManagementFactory;

public class BeanTester
{
    public static void main(String[] args)
    {
        System.out.println("Hello, World!");
        ibmThreadMxBean();
        sunThreadMxBean();
    }

    private static void ibmThreadMxBean()
    {
        System.out.println("IBM ThreadMXBean");
        com.ibm.lang.management.ThreadMXBean ibmThreadBean = ExtendedThreadMXBeanImpl.getInstance();
        System.out.printf("isThreadAllocatedMemorySupported : %s%n", ibmThreadBean.isThreadAllocatedMemorySupported());
        System.out.printf("getThreadAllocatedBytes : %d%n", ibmThreadBean.getThreadAllocatedBytes(Thread.currentThread().getId()));
    }

    private static void sunThreadMxBean()
    {
        System.out.println("Sun ThreadMXBean");
        ThreadMXBean sunThreadBean = (ThreadMXBean) ManagementFactory.getThreadMXBean();
        System.out.printf("isThreadAllocatedMemorySupported : %s%n", sunThreadBean.isThreadAllocatedMemorySupported());
        System.out.printf("getThreadAllocatedBytes : %d%n", sunThreadBean.getThreadAllocatedBytes(Thread.currentThread().getId()));
    }
}
