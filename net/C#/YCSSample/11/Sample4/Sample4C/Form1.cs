using System.Net.Sockets;

namespace Sample4C
{
    public partial class Form1 : Form
    {
        public static string HOST = "localhost";
        public static int PORT = 10000;

        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void Bt_Click(object sender, EventArgs e)
        {
            TcpClient tc = new(HOST, PORT);

            StreamReader sr = new(tc.GetStream());
            string? str = sr.ReadLine();
            textBox1.Text = str;

            sr.Close();
            tc.Close();
        }
    }
}