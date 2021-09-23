namespace TextBoxSample8
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
            this.tb = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // lb
            // 
            this.lb.AutoSize = true;
            this.lb.Dock = System.Windows.Forms.DockStyle.Top;
            this.lb.Location = new System.Drawing.Point(0, 0);
            this.lb.Name = "lb";
            this.lb.Size = new System.Drawing.Size(87, 15);
            this.lb.TabIndex = 0;
            this.lb.Text = "いらっしゃいませ。";
            // 
            // tb
            // 
            this.tb.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.tb.Location = new System.Drawing.Point(0, 138);
            this.tb.Name = "tb";
            this.tb.Size = new System.Drawing.Size(234, 23);
            this.tb.TabIndex = 1;
            this.tb.KeyDown += new System.Windows.Forms.KeyEventHandler(this.Tb_KeyDown);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(234, 161);
            this.Controls.Add(this.tb);
            this.Controls.Add(this.lb);
            this.Name = "Form1";
            this.Text = "サンプル";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lb;
        private System.Windows.Forms.TextBox tb;
    }
}

