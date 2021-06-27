using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Item2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

            WhiteLabel[] wlb = new WhiteLabel[2];

            for(int i = 0; i < 2; i++)
            {
                wlb[i] = new WhiteLabel();
            }
            wlb[0].Text = "こんにちは";
            wlb[0].Left = 0;
            wlb[0].Parent = this;

            wlb[1].Text = "ありがとう";
            wlb[1].Left = 100;
            wlb[1].Parent = this;
        }
    }
}
