using System.Net;

namespace Sample1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            string hn = Dns.GetHostName();
            IPHostEntry ih = Dns.GetHostEntry(hn);

            IPAddress ia = ih.AddressList[0];

            lb1.Width = 300;
            lb1.Top = 0;
            lb1.Text = "ホスト名：" + hn;

            lb2.Width = 300;
            lb2.Top = lb1.Bottom;
            lb2.Text = "IPアドレス：" + ia.ToString();
        }
    }
}