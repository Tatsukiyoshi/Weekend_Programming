-- SHIFT-JIS
-- �@ユーザーテーブルのデータをテンポラリテーブルにバックアップ
SELECT * INTO #Temp FROM [MainDatabase].[dbo].[employee]
 
-- �Aユーザーテーブルを削除
DROP TABLE [MainDatabase].[dbo].[employee]
 
-- �B年齢カラムを追加してユーザーテーブルを再作成
CREATE TABLE [MainDatabase].[dbo].[employee]
(
	id INT PRIMARY KEY,
	name VARCHAR(50),
	address VARCHAR(255),
	age INT,
	gender INT
)

-- �Cテンポラリテーブルからバックアップデータを復元
INSERT INTO [MainDatabase].[dbo].[employee]
SELECT
	Tmp.id,
	Tmp.name,
	'',
	Tmp.age,
	Tmp.gender
FROM #Temp Tmp
 
-- �Dテンポラリテーブルを削除
DROP TABLE #Temp