using System.Net.Sockets;

namespace Sample5C
{
    public partial class Form1 : Form
    {
        public static string HOST = "localhost";
        public static int PORT = 10000;

        private TcpClient? tc;
        private StreamReader? sr;
        private StreamWriter? sw;

        public Form1()
        {
            InitializeComponent();

            Thread th = new Thread(this.Run);
            th.Start();
        }

        private void Bt_Click(object sender, EventArgs e)
        {
            string str = tb1.Text;
            if(str != null) {
                sw?.WriteLine(str);
                tb2.AppendText(str + "\n");
                sw?.Flush();
                tb1.Clear();
            }
        }

        public void Run()
        {
            tc = new TcpClient(HOST, PORT);
            sw = new StreamWriter(tc.GetStream());
            sr = new StreamReader(tc.GetStream());

            while (true)
            {
                try
                {
                    String? str = sr.ReadLine();
                    tb2.Invoke((MethodInvoker)delegate
                    {
                        tb2.AppendText(str + "\n");
                    });
                }
                catch
                {
                    sr.Close();
                    sw?.Close();
                    tc.Close();
                    break;
                }
            }
        }
    }
}