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

                //非同期実行
                await Task.Run(() =>
                {
                    //読み込み完了まで待機
                    if (condition.Wait(5000))
                        result = "ok";
                    else
                        result = "timeout";
                });

                MessageBox.Show(result);
            }
            catch {
                MessageBox.Show("URLを入力してください。");
            }
        }

        private void webView21_NavigationCompleted(object sender, Microsoft.Web.WebView2.Core.CoreWebView2NavigationCompletedEventArgs e)
        {
            //読み込み結果を判定
            if (e.IsSuccess)
                Console.WriteLine("Complete");
            else
                Console.WriteLine(e.WebErrorStatus);

            //シグナル初期化
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