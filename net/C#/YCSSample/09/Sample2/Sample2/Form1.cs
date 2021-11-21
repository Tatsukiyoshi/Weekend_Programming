using Timer = System.Windows.Forms.Timer;

namespace Sample2
{
    public partial class Form1 : Form
    {
        private int t;  // 経過時間

        public Form1()
        {
            InitializeComponent();

            this.DoubleBuffered = true;
            t = 0;

            Timer tm = new Timer();
            tm.Interval = 100;
            tm.Start();

            this.Paint += new PaintEventHandler(Fm_Paint);
            tm.Tick += new EventHandler(Tm_Tick);
        }

        private void Tm_Tick(object? sender, EventArgs e)
        {
            t++;
            if (t > 600) t = 0; // 1分経過で最初に戻ります

            this.Invalidate();
        }

        private void Fm_Paint(object? sender, PaintEventArgs e)
        {
            Graphics g = e.Graphics;

            int w = this.ClientSize.Width;
            int h = this.ClientSize.Height;

            // 未経過時間を楕円で描画します
            g.FillEllipse(new SolidBrush(Color.DeepPink), 0, 0, w, h);

            // 経過時間分を円弧で描画します
            g.FillPie(new SolidBrush(Color.DarkOrchid), 0, 0, w, h, -90, (float)0.6 * t);

            // 中心部分を楕円で描画します
            g.FillEllipse(new SolidBrush(Color.Bisque), (int)(w / 4), (int)(h / 4), (int)(w / 2), (int)(h / 2));

            // 経過時間を表す文字列
            string time = t / 10 + ":" + "0" + t % 10;

            // 指定フォントで表示した場合のサイズを調べます
            Font f = new("Courier", 20);
            SizeF ts = g.MeasureString(time, f);

            // 中央を調べます
            float tx = (w - ts.Width) / 2;
            float ty = (h - ts.Height) / 2;

            g.DrawString(time, f, new SolidBrush(Color.Black), tx, ty);
        }
    }
}