namespace Sample4
{
    public partial class Form1 : Form
    {
        private List<Point> listPoint;

        public Form1()
        {
            InitializeComponent();

            listPoint = new List<Point>();

            this.MouseDown += new MouseEventHandler(fm_MouseDown);
            this.Paint += new PaintEventHandler(fm_Paint);
        }

        private void fm_Paint(object? sender, PaintEventArgs e)
        {
            Graphics g = e.Graphics;
            Pen dp = new Pen(Color.Black, 1);

            foreach(Point p in listPoint)
            {
                g.DrawEllipse(dp, p.X, p.Y, 10, 10);
            }
        }

        private void fm_MouseDown(object? sender, MouseEventArgs e)
        {
            Point p = new Point();

            p.X = e.X;
            p.Y = e.Y;
            listPoint.Add(p);

            this.Invalidate();
        }
    }
}