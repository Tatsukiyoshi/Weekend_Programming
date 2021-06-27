using System.Windows.Forms;

class Sample9
{
    public static void Main()
    {
        Form fm = new Form();
        fm.Text = "サンプル";
        fm.Width = 250; fm.Height = 150;

        // ジャグ配列
        string[][] str = new string[4][]{
            new string[] {"東京",  "Tokyo",    "とうきょう",   "トウキョウ"},
            new string[] {"名古屋","Nagoya",   "なごや" },
            new string[] {"大阪",  "Osaka",    "おおさか",    "オオサカ"},
            new string[] {"福岡",  "Fukuoka",  "ふくおか"}
        };

        Label lb = new Label();
        lb.Width = fm.Width; lb.Height = fm.Height;

        // テンポラリ
        string tmp = "";

        for (int i = 0; i < str.Length; i++)
        {
            tmp += "(";

            for (int j = 0; j < str[i].Length; j++)
            {
                tmp += str[i][j];
                tmp += ",";
            }

            tmp += ")\n";
        }

        lb.Text = tmp;
        lb.Parent = fm;

        Application.Run(fm);
    }
}
