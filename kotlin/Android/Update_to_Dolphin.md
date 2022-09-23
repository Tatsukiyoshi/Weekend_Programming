*   起動時例外発生
    ```
        内部エラーが発生しました。Please refer to https://code.google.com/p/android/issues

    com.intellij.ide.plugins.StartupAbortedException: UI initialization failed
        at com.intellij.idea.StartupUtil.lambda$start$15(StartupUtil.java:268)
        at java.base/java.util.concurrent.CompletableFuture.uniExceptionally(CompletableFuture.java:986)
        at java.base/java.util.concurrent.CompletableFuture$UniExceptionally.tryFire(CompletableFuture.java:970)
        at java.base/java.util.concurrent.CompletableFuture.postComplete(CompletableFuture.java:506)
        at java.base/java.util.concurrent.CompletableFuture.postFire(CompletableFuture.java:610)
        at java.base/java.util.concurrent.CompletableFuture$UniRun.tryFire(CompletableFuture.java:791)
        at java.base/java.util.concurrent.CompletableFuture$Completion.run(CompletableFuture.java:478)
        at java.desktop/java.awt.event.InvocationEvent.dispatch(InvocationEvent.java:313)
        at java.desktop/java.awt.EventQueue.dispatchEventImpl(EventQueue.java:776)
        at java.desktop/java.awt.EventQueue$4.run(EventQueue.java:727)
        at java.desktop/java.awt.EventQueue$4.run(EventQueue.java:721)
        at java.base/java.security.AccessController.doPrivileged(Native Method)
        at java.base/java.security.ProtectionDomain$JavaSecurityAccessImpl.doIntersectionPrivilege(ProtectionDomain.java:85)
        at java.desktop/java.awt.EventQueue.dispatchEvent(EventQueue.java:746)
        at java.desktop/java.awt.EventDispatchThread.pumpOneEventForFilters(EventDispatchThread.java:203)
        at java.desktop/java.awt.EventDispatchThread.pumpEventsForFilter(EventDispatchThread.java:124)
        at java.desktop/java.awt.EventDispatchThread.pumpEventsForHierarchy(EventDispatchThread.java:113)
        at java.desktop/java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:109)
        at java.desktop/java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:101)
        at java.desktop/java.awt.EventDispatchThread.run(EventDispatchThread.java:90)
    Caused by: java.util.concurrent.CompletionException: java.lang.VerifyError: Expecting a stack map frame
    Exception Details:
    Location:
        com/intellij/openapi/util/text/StringUtil.pluralize(Ljava/lang/String;I)Ljava/lang/String; @7: nop
    Reason:
        Expected stackmap frame at this location.
    Bytecode:
        0000000: 2ab0 0000 a7ff fe00 bf00 00a7 fffe     
    Stackmap Table:
        same_frame(@2)
        same_frame(@9)

        at java.base/java.util.concurrent.CompletableFuture.encodeThrowable(CompletableFuture.java:314)
        at java.base/java.util.concurrent.CompletableFuture.completeThrowable(CompletableFuture.java:319)
        at java.base/java.util.concurrent.CompletableFuture$UniRun.tryFire(CompletableFuture.java:787)
        ... 14 more
    Caused by: java.lang.VerifyError: Expecting a stack map frame
    Exception Details:
    Location:
        com/intellij/openapi/util/text/StringUtil.pluralize(Ljava/lang/String;I)Ljava/lang/String; @7: nop
    Reason:
        Expected stackmap frame at this location.
    Bytecode:
        0000000: 2ab0 0000 a7ff fe00 bf00 00a7 fffe     
    Stackmap Table:
        same_frame(@2)
        same_frame(@9)

        at com.intellij.openapi.util.SystemInfo.isOsVersionAtLeast(SystemInfo.java:51)
        at com.intellij.openapi.util.SystemInfo.<clinit>(SystemInfo.java:54)
        at com.intellij.ui.JreHiDpiUtil.isJreHiDPIEnabled(JreHiDpiUtil.java:58)
        at com.intellij.ui.scale.JBUIScale.getOrComputeUserScaleFactor(JBUIScale.java:190)
        at com.intellij.ui.scale.JBUIScale.scale(JBUIScale.java:314)
        at com.intellij.ui.scale.UserScaleContext.<init>(UserScaleContext.java:26)
        at com.intellij.util.ui.JBUI$BaseScaleContext.<init>(JBUI.java:1408)
        at com.intellij.ui.scale.ScaleContext.<init>(ScaleContext.java:32)
        at com.intellij.ui.scale.ScaleContext.create(ScaleContext.java:108)
        at com.intellij.ui.scale.ScaleContextSupport.<init>(ScaleContextSupport.java:11)
        at com.intellij.openapi.util.IconLoader$CachedImageIcon.<init>(IconLoader.java:702)
        at com.intellij.ui.CoreIconManager$IconWithToolTipImpl.<init>(CoreIconManager.java:91)
        at com.intellij.ui.CoreIconManager.loadRasterizedIcon(CoreIconManager.java:61)
        at com.intellij.icons.AllIcons.load(AllIcons.java:17)
        at com.intellij.icons.AllIcons.<clinit>(AllIcons.java:670)
        at com.intellij.icons.AllIcons$Nodes.<clinit>(AllIcons.java:719)
        at com.intellij.ide.ui.laf.IdeaLaf.initIdeaDefaults(IdeaLaf.java:74)
        at com.intellij.ide.ui.laf.IdeaLaf.initComponentDefaults(IdeaLaf.java:35)
        at java.desktop/javax.swing.plaf.basic.BasicLookAndFeel.getDefaults(BasicLookAndFeel.java:150)
        at java.desktop/javax.swing.plaf.metal.MetalLookAndFeel.getDefaults(MetalLookAndFeel.java:1560)
        at com.intellij.idea.StartupUtil.lambda$scheduleInitUi$21(StartupUtil.java:476)
        at com.intellij.ui.scale.JBUIScale.computeSystemFontData(JBUIScale.java:69)
        at com.intellij.ui.scale.JBUIScale.getSystemFontData(JBUIScale.java:360)
        at com.intellij.idea.StartupUtil.lambda$scheduleInitUi$22(StartupUtil.java:474)
        at java.base/java.util.concurrent.CompletableFuture$UniRun.tryFire(CompletableFuture.java:783)
        ... 14 more

    -----
    Your JRE: 11.0.13+0-b1751.21-8125866 amd64 (JetBrains s.r.o.)
    D:\Program Files\Android\Android Studio\jre
    ```
