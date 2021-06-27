// NLog 調査
// https://qiita.com/developpermanati/items/1de20d836070f42049cf

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

namespace SampleFormsApp3
{
    public static class NLogService
    {
        private static Logger logger = LogManager.GetCurrentClassLogger();

        public static void PrintInfoLog(string str)
        {
            logger.Info(str);
        }
    }
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            NLogService.PrintInfoLog("Hello World");
        }
    }
}
