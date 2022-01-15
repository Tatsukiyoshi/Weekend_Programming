namespace Sample8
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        private PictureBox[] pb;
        private TabControl tc;
        private TabPage[] tp;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(300, 200);
            this.Text = "サンプル";

            // タブを作成
            tc = new TabControl();

            // Bitmapファイルのファイル名を配列にセットする
            string dir = "..\\..\\..\\..\\..\\..\\data";
            string[] fls = Directory.GetFiles(dir, "*.bmp");            

            // ファイル数分のPictureBoxとタブページを作成する
            pb = new PictureBox[fls.Length];
            tp = new TabPage[fls.Length];

            // ファイル数分繰り返す
            for(int i = 0; i < fls.Length; i++)
            {
                // PictureBoxにBitmap画像を読み込む
                pb[i] = new PictureBox();
                pb[i].Image = Image.FromFile(fls[i]);

                // コントロールの高さと幅を調整
                pb[i].Height = pb[i].Image.Height;
                pb[i].Width = pb[i].Image.Width;
                if(tc.Height < pb[i].Height)
                {
                    tc.Height = pb[i].Height;
                }
                if (tc.Width < pb[i].Width)
                {
                    tc.Width = pb[i].Width;
                }

                // タブページのキャプションにファイル名をセットする
                // tp[i] = new TabPage(fls[i]);
                tp[i] = new TabPage(Path.GetFileName(fls[i]));
                tp[i].Controls.Add(pb[i]);
                tc.Controls.Add(tp[i]);
                
            }

            tc.Parent = this;

            // フォームのサイズを調整
            this.Height = tc.Height + 100;
            this.Width = tc.Width + 50;
        }

        #endregion
    }
}