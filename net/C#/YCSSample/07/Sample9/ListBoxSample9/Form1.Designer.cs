namespace ListBoxSample9
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

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
            this.lb = new System.Windows.Forms.Label();
            this.lbx = new System.Windows.Forms.ListBox();
            this.SuspendLayout();
            // 
            // lb
            // 
            this.lb.AutoSize = true;
            this.lb.Dock = System.Windows.Forms.DockStyle.Top;
            this.lb.Location = new System.Drawing.Point(0, 0);
            this.lb.Name = "lb";
            this.lb.Size = new System.Drawing.Size(85, 12);
            this.lb.TabIndex = 0;
            this.lb.Text = "いらっしゃいませ。";
            // 
            // lbx
            // 
            this.lbx.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.lbx.FormattingEnabled = true;
            this.lbx.ItemHeight = 12;
            this.lbx.Items.AddRange(new object[] {
            "乗用車",
            "トラック",
            "オープンカー",
            "タクシー",
            "スポーツカー",
            "ミニカー",
            "自転車",
            "三輪車",
            "バイク",
            "飛行機",
            "ヘリコプター",
            "ロケット"});
            this.lbx.Location = new System.Drawing.Point(0, 73);
            this.lbx.Name = "lbx";
            this.lbx.Size = new System.Drawing.Size(234, 88);
            this.lbx.TabIndex = 1;
            this.lbx.SelectedIndexChanged += new System.EventHandler(this.lbx_SelectedIndexChanged);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(234, 161);
            this.Controls.Add(this.lbx);
            this.Controls.Add(this.lb);
            this.Name = "Form1";
            this.Text = "サンプル";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lb;
        private System.Windows.Forms.ListBox lbx;
    }
}

