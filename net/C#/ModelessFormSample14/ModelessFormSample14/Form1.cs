using System;
using System.Windows.Forms;

namespace ModelessFormSample14
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void bt_Click(object sender, EventArgs e)
        {
            SampleForm sf = new SampleForm();
            sf.Show();
        }
    }
}
