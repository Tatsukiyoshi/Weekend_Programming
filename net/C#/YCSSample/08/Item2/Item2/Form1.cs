// To use Configuration, Add package "ConfigurationManager" from Nuget Manager 

using System.Drawing.Drawing2D;
using System.Configuration;

namespace Item2
{
    public partial class Form1 : Form
    {
        // FullPath of Image(.NET Framework and .NET 5 and later)
#if (NET5_0_OR_GREATER)
        private const string strImagePath = "..\\..\\..\\..\\..\\..\\data\\";
#else
        private const string strImagePath = "..\\..\\..\\..\\..\\data\\";
#endif
        private const string strImageFile = "car.bmp";
        private string strImageFullPath = Directory.GetCurrentDirectory() + "\\" + strImagePath + strImageFile;

        private readonly Image im;
        private readonly int ei;    // Interval of Enlarge
        private int cx, cy;         // Size of Car

        public Form1()
        {
            InitializeComponent();

            im = Image.FromFile(strImageFullPath);
            cx = 200;
            cy = 100;

            ei = Convert.ToInt32(ConfigurationManager.AppSettings["EnlargeInterval"]);

            // Set interval of timer and start the timer
            tm.Interval = Convert.ToInt32(ConfigurationManager.AppSettings["TimerInterval"]);
            tm.Start();
        }

        private void Tm_Tick(object sender, EventArgs e)
        {
            if (cx + ei <= this.ClientSize.Width || cy + ei <= this.ClientSize.Height)
            {
                cx += ei;
                cy += ei;

                this.Invalidate();  // re-Paint
            }
        }

        private void Form1_Paint(object sender, PaintEventArgs e)
        {
            Graphics g = e.Graphics;
            GraphicsPath gp = new GraphicsPath();

            gp.AddEllipse(new Rectangle(0, 0, cx, cy));
            Region rg = new Region(gp);
            g.Clip = rg;

            g.DrawImage(im, 0, 0, this.Width, this.Height);
        }
    }
}