namespace Sample3
{
    public partial class Form1 : Form
    {
        readonly CountdownEvent condition = new CountdownEvent(1);

        public Form1()
        {
            InitializeComponent();
            InitializeAsync();
        }

        private async void InitializeAsync()
        {
            webView21 = new Microsoft.Web.WebView2.WinForms.WebView2();
            await webView21.EnsureCoreWebView2Async(null);
        }

        // https://web.biz-prog.net/readme/webview_new2.html
        private async void tsb1_Click(object sender, EventArgs e)
        {
            string result = "";

            try
            {
                webView21.CoreWebView2.Navigate(textBox1.Text);

                //�񓯊����s
                await Task.Run(() =>
                {
                    //�ǂݍ��݊����܂őҋ@
                    if (condition.Wait(5000))
                        result = "ok";
                    else
                        result = "timeout";
                });

                MessageBox.Show(result);
            }
            catch {
                MessageBox.Show("URL����͂��Ă��������B");
            }
        }

        private void webView21_NavigationCompleted(object sender, Microsoft.Web.WebView2.Core.CoreWebView2NavigationCompletedEventArgs e)
        {
            //�ǂݍ��݌��ʂ𔻒�
            if (e.IsSuccess)
                Console.WriteLine("Complete");
            else
                Console.WriteLine(e.WebErrorStatus);

            //�V�O�i��������
            condition.Signal();
            System.Threading.Thread.Sleep(1);
            condition.Reset();
        }

        private void tsb2_Click(object sender, EventArgs e)
        {
            if (webView21.CanGoBack)
            {
                webView21.GoBack();
            }
        }
    }
}