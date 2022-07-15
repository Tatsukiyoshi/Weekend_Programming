namespace DrawApp
{
    partial class DrawApp
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
            this.ms = new System.Windows.Forms.MenuStrip();
            this.miFile = new System.Windows.Forms.ToolStripMenuItem();
            this.miOpen = new System.Windows.Forms.ToolStripMenuItem();
            this.miSave = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripSeparator1 = new System.Windows.Forms.ToolStripSeparator();
            this.miPreview = new System.Windows.Forms.ToolStripMenuItem();
            this.miPrint = new System.Windows.Forms.ToolStripMenuItem();
            this.miConfig = new System.Windows.Forms.ToolStripMenuItem();
            this.miShape = new System.Windows.Forms.ToolStripMenuItem();
            this.miRectangle = new System.Windows.Forms.ToolStripMenuItem();
            this.miOval = new System.Windows.Forms.ToolStripMenuItem();
            this.miLine = new System.Windows.Forms.ToolStripMenuItem();
            this.miColor = new System.Windows.Forms.ToolStripMenuItem();
            this.pd = new System.Drawing.Printing.PrintDocument();
            this.ms.SuspendLayout();
            this.SuspendLayout();
            // 
            // ms
            // 
            this.ms.ImageScalingSize = new System.Drawing.Size(24, 24);
            this.ms.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.miFile,
            this.miConfig});
            this.ms.Location = new System.Drawing.Point(0, 0);
            this.ms.Name = "ms";
            this.ms.Size = new System.Drawing.Size(578, 33);
            this.ms.TabIndex = 0;
            this.ms.Text = "menuStrip1";
            // 
            // miFile
            // 
            this.miFile.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.miOpen,
            this.miSave,
            this.toolStripSeparator1,
            this.miPreview,
            this.miPrint});
            this.miFile.Name = "miFile";
            this.miFile.Size = new System.Drawing.Size(79, 29);
            this.miFile.Text = "ファイル";
            // 
            // miOpen
            // 
            this.miOpen.Name = "miOpen";
            this.miOpen.Size = new System.Drawing.Size(212, 34);
            this.miOpen.Text = "開く";
            this.miOpen.Click += new System.EventHandler(this.MiOpen_Click);
            // 
            // miSave
            // 
            this.miSave.Name = "miSave";
            this.miSave.Size = new System.Drawing.Size(212, 34);
            this.miSave.Text = "保存";
            this.miSave.Click += new System.EventHandler(this.MiSave_Click);
            // 
            // toolStripSeparator1
            // 
            this.toolStripSeparator1.Name = "toolStripSeparator1";
            this.toolStripSeparator1.Size = new System.Drawing.Size(209, 6);
            // 
            // miPreview
            // 
            this.miPreview.Name = "miPreview";
            this.miPreview.Size = new System.Drawing.Size(212, 34);
            this.miPreview.Text = "印刷プレビュー";
            this.miPreview.Click += new System.EventHandler(this.MiPreview_Click);
            // 
            // miPrint
            // 
            this.miPrint.Name = "miPrint";
            this.miPrint.Size = new System.Drawing.Size(212, 34);
            this.miPrint.Text = "印刷";
            this.miPrint.Click += new System.EventHandler(this.MiPrint_Click);
            // 
            // miConfig
            // 
            this.miConfig.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.miShape,
            this.miColor});
            this.miConfig.Name = "miConfig";
            this.miConfig.Size = new System.Drawing.Size(64, 29);
            this.miConfig.Text = "設定";
            // 
            // miShape
            // 
            this.miShape.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.miRectangle,
            this.miOval,
            this.miLine});
            this.miShape.Name = "miShape";
            this.miShape.Size = new System.Drawing.Size(150, 34);
            this.miShape.Text = "図形";
            // 
            // miRectangle
            // 
            this.miRectangle.Name = "miRectangle";
            this.miRectangle.Size = new System.Drawing.Size(168, 34);
            this.miRectangle.Text = "四角形";
            this.miRectangle.Click += new System.EventHandler(this.MiRectangle_Click);
            // 
            // miOval
            // 
            this.miOval.Name = "miOval";
            this.miOval.Size = new System.Drawing.Size(168, 34);
            this.miOval.Text = "楕円";
            this.miOval.Click += new System.EventHandler(this.MiOval_Click);
            // 
            // miLine
            // 
            this.miLine.Name = "miLine";
            this.miLine.Size = new System.Drawing.Size(168, 34);
            this.miLine.Text = "直線";
            this.miLine.Click += new System.EventHandler(this.MiLine_Click);
            // 
            // miColor
            // 
            this.miColor.Name = "miColor";
            this.miColor.Size = new System.Drawing.Size(150, 34);
            this.miColor.Text = "色";
            this.miColor.Click += new System.EventHandler(this.MiColor_Click);
            // 
            // pd
            // 
            this.pd.PrintPage += new System.Drawing.Printing.PrintPageEventHandler(this.pd_PrintPage);
            // 
            // DrawApp
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(10F, 25F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(578, 344);
            this.Controls.Add(this.ms);
            this.MainMenuStrip = this.ms;
            this.Name = "DrawApp";
            this.Text = "DrawApp";
            this.Paint += new System.Windows.Forms.PaintEventHandler(this.DrawApp_Paint);
            this.MouseDown += new System.Windows.Forms.MouseEventHandler(this.DrawApp_MouseDown);
            this.MouseUp += new System.Windows.Forms.MouseEventHandler(this.DrawApp_MouseUp);
            this.ms.ResumeLayout(false);
            this.ms.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private MenuStrip ms;
        private ToolStripMenuItem miFile;
        private ToolStripMenuItem miOpen;
        private ToolStripMenuItem miSave;
        private ToolStripMenuItem miConfig;
        private ToolStripMenuItem miShape;
        private ToolStripMenuItem miRectangle;
        private ToolStripMenuItem miOval;
        private ToolStripMenuItem miLine;
        private ToolStripMenuItem miColor;
        private ToolStripSeparator toolStripSeparator1;
        private ToolStripMenuItem miPreview;
        private ToolStripMenuItem miPrint;
        private System.Drawing.Printing.PrintDocument pd;
    }
}