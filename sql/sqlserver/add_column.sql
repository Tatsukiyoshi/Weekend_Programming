-- �@���[�U�[�e�[�u���̃f�[�^���e���|�����e�[�u���Ƀo�b�N�A�b�v
SELECT * INTO #Temp FROM [MainDatabase].[dbo].[employee]
 
-- �A���[�U�[�e�[�u�����폜
DROP TABLE [MainDatabase].[dbo].[employee]
 
-- �B�N��J������ǉ����ă��[�U�[�e�[�u�����č쐬
CREATE TABLE [MainDatabase].[dbo].[employee]
(
	id INT PRIMARY KEY,
	name VARCHAR(50),
	address VARCHAR(255),
	age INT,
	gender INT
)

-- �C�e���|�����e�[�u������o�b�N�A�b�v�f�[�^�𕜌�
INSERT INTO [MainDatabase].[dbo].[employee]
SELECT
	Tmp.id,
	Tmp.name,
	'',
	Tmp.age,
	Tmp.gender
FROM #Temp Tmp
 
-- �D�e���|�����e�[�u�����폜
DROP TABLE #Temp