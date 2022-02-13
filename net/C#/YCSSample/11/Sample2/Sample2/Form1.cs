using System.Net;

namespace Sample2
{
    public partial class Form1 : Form
    {
        private Label[] lb = new Label[5];

        public Form1()
        {
            InitializeComponent();
        }

        private void bt_Click(object sender, EventArgs e)
        {
            try
            {
                IPHostEntry ih = Dns.GetHostEntry(tb.Text);
                IPAddress ia = ih.AddressList[0];

                lb2.Text = ih.HostName;
                lb4.Text = ia.ToString();
            }
            catch
            {
                MessageBox.Show("ÉGÉâÅ[Ç™î≠ê∂ÇµÇ‹ÇµÇΩÅB");
            }
        }
    }
}