namespace Sample3
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
            this.toolStrip1 = new System.Windows.Forms.ToolStrip();
            this.tsb1 = new System.Windows.Forms.ToolStripButton();
            this.tsb2 = new System.Windows.Forms.ToolStripButton();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.webView21 = new Microsoft.Web.WebView2.WinForms.WebView2();
            this.toolStrip1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.webView21)).BeginInit();
            this.SuspendLayout();
            // 
            // toolStrip1
            // 
            this.toolStrip1.ImageScalingSize = new System.Drawing.Size(24, 24);
            this.toolStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.tsb1,
            this.tsb2});
            this.toolStrip1.Location = new System.Drawing.Point(0, 0);
            this.toolStrip1.Name = "toolStrip1";
            this.toolStrip1.Size = new System.Drawing.Size(578, 33);
            this.toolStrip1.TabIndex = 0;
            this.toolStrip1.Text = "toolStrip1";
            // 
            // tsb1
            // 
            this.tsb1.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.tsb1.Image = global::Sample3.Properties.Resources.go;
            this.tsb1.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.tsb1.Name = "tsb1";
            this.tsb1.Size = new System.Drawing.Size(34, 28);
            this.tsb1.Text = "Go";
            this.tsb1.Click += new System.EventHandler(this.tsb1_Click);
            // 
            // tsb2
            // 
            this.tsb2.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.tsb2.Image = global::Sample3.Properties.Resources.back_button;
            this.tsb2.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.tsb2.Name = "tsb2";
            this.tsb2.Size = new System.Drawing.Size(34, 28);
            this.tsb2.Text = "←";
            this.tsb2.Click += new System.EventHandler(this.tsb2_Click);
            // 
            // textBox1
            // 
            this.textBox1.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.textBox1.Location = new System.Drawing.Point(0, 313);
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(578, 31);
            this.textBox1.TabIndex = 1;
            this.textBox1.Text = "http://";
            // 
            // webView21
            // 
            this.webView21.AllowExternalDrop = true;
            this.webView21.CreationProperties = null;
            this.webView21.DefaultBackgroundColor = System.Drawing.Color.White;
            this.webView21.Dock = System.Windows.Forms.DockStyle.Fill;
            this.webView21.Location = new System.Drawing.Point(0, 33);
            this.webView21.Name = "webView21";
            this.webView21.Size = new System.Drawing.Size(578, 280);
            this.webView21.TabIndex = 2;
            this.webView21.ZoomFactor = 1D;
            this.webView21.NavigationCompleted += new System.EventHandler<Microsoft.Web.WebView2.Core.CoreWebView2NavigationCompletedEventArgs>(this.webView21_NavigationCompleted);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(10F, 25F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(578, 344);
            this.Controls.Add(this.webView21);
            this.Controls.Add(this.textBox1);
            this.Controls.Add(this.toolStrip1);
            this.Name = "Form1";
            this.Text = "サンプル";
            this.toolStrip1.ResumeLayout(false);
            this.toolStrip1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.webView21)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private ToolStrip toolStrip1;
        private ToolStripButton tsb1;
        private ToolStripButton tsb2;
        private TextBox textBox1;
        private Microsoft.Web.WebView2.WinForms.WebView2 webView21;
    }
}