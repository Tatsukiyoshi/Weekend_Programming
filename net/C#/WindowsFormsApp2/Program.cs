using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;
using NLog;

namespace WindowsFormsApp2
{
    public static class NLogService
    {
        private static Logger logger = LogManager.GetCurrentClassLogger();

        public static void PrintInfoLog(string str)
        {
            logger.Info(str);
        }
    }

    static class Program
    {
        /// <summary>
        /// The main entry point for the application.
        /// </summary>
        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new Form1());
        }
    }
}
