using Timer = System.Windows.Forms.Timer;

namespace Item1
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

            int cw = this.ClientSize.Width;
            int ch = this.ClientSize.Height;
            int rh = ch - (int)(0.5 * t);

            // 未経過時間を長方形で描画します
            g.FillRectangle(new SolidBrush(Color.DeepPink), 0, 0, cw, ch);

            // 経過時間分を長方形で描画します
            // g.FillRectangle(new SolidBrush(Color.DarkOrchid), 0, ch - rh, cw, rh); // 水が減っていく感じ
            g.FillRectangle(new SolidBrush(Color.DarkOrchid), 0, 0, cw, rh);

            // 経過時間を表す文字列
            string time = t / 10 + ":" + "0" + t % 10;

            // 指定フォントで表示した場合のサイズを調べます
            Font f = new("Courier", 20);
            SizeF ts = g.MeasureString(time, f);

            // 中央を調べます
            float tx = (cw - ts.Width) / 2;
            float ty = (ch - ts.Height) / 2;

            g.DrawString(time, f, new SolidBrush(Color.Black), tx, ty);
        }
    }
}