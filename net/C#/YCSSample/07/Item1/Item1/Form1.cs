using System.Drawing;
using System.Windows.Forms;

namespace Item1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void rb1_CheckedChanged(object sender, System.EventArgs e)
        {
            lb.ForeColor = Color.Yellow;
        }

        private void rb2_CheckedChanged(object sender, System.EventArgs e)
        {
            lb.ForeColor = Color.Red;
        }
        private void rb3_CheckedChanged(object sender, System.EventArgs e)
        {
            lb.ForeColor = Color.Blue;
        }

    }
}
