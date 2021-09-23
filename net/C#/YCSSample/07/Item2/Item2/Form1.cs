using System;
using System.Drawing;
using System.Windows.Forms;

namespace Item2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void rb1_CheckedChanged(object sender, EventArgs e)
        {
            lb.Font = new Font("Arial", 12, FontStyle.Regular);
        }

        private void rb2_CheckedChanged(object sender, EventArgs e)
        {
            lb.Font = new Font("Arial", 12, FontStyle.Bold);
        }

        private void rb3_CheckedChanged(object sender, EventArgs e)
        {
            lb.Font = new Font("Arial", 12, FontStyle.Italic);
        }
    }
}
