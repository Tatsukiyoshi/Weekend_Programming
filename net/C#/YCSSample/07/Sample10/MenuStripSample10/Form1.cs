using System;
using System.Windows.Forms;

namespace MenuStripSample10
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void mi_Click(object sender, EventArgs e)
        {
            ToolStripMenuItem mi = (ToolStripMenuItem)sender;
            lb.Text = mi.Text + "ですね。";
        }
    }
}
