using System.Xml;
    
    namespace Sample7
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        private TreeView tv;
        private const String xmlPath = "..\\..\\..\\Sample.xml";

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
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Text = "サンプル";

            tv = new TreeView();
            tv.Dock = DockStyle.Fill;

            XmlDocument doc = new XmlDocument();
            doc.Load(xmlPath);

            XmlNode xmlRoot = doc.DocumentElement;
            TreeNode treeRoot = new TreeNode();
            treeRoot.Text = xmlRoot.Name;
            tv.Nodes.Add(treeRoot);

            walk(xmlRoot, treeRoot);

            tv.Parent = this;
        }

        private void walk(XmlNode ixn, TreeNode itn)
        {
            for(XmlNode ch = ixn.FirstChild; ch != null; ch = ch.NextSibling)
            {
                TreeNode tn = new TreeNode();
                itn.Nodes.Add(tn);
                walk(ch, tn);

                switch (ch.NodeType)
                {
                    case XmlNodeType.Element:
                        tn.Text = ch.Name;
                        break;

                    default:
                        tn.Text = ch.Value;
                        break;
                }
            }
        }

        #endregion
    }
}