using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using NLog;

namespace WindowsFormsApp2
{
    public partial class MainForm : Form
    {
        public MainForm()
        {
            InitializeComponent();
        }

        // 色選択メニューの選択
        private void TextColor_Click(object sender, EventArgs e)
        {
            Program.PrintInfoLog("TextColor Clicked!");

            SettingForm SettingForm1 = new SettingForm();
            SettingForm1.ShowDialog();
        }
    }
}
