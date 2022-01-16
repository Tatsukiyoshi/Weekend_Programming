namespace Sample9
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        private ChildForm[] cf;

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
            this.ClientSize = new System.Drawing.Size(400, 400);
            this.IsMdiContainer = true;
            this.Text = "サンプル";

            // ファイルのリストを得る
            string dir = "..\\..\\..\\..\\..\\..\\data";
            string[] fls = Directory.GetFiles(dir, "*.xml");

            cf = new ChildForm[fls.Length];

            for(int i = 0; i < fls.Length; i++)
            {
                cf[i] = new ChildForm(fls[i]);
                cf[i].MdiParent = this;
                cf[i].Show();
            }

        }

        #endregion
    }
}