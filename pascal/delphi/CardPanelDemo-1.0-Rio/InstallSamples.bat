:: Check if "DEMOSDIR" is defined, if it is then copy the files

:: First parameter: Folder of the Samples in the zip files
:: Second parameter: Destination Folder inside "DEMOSDIR"

:: Example
:: Inside the zip file there is a Folder containing the Samples --> Samples\*.*
:: Execution --> InstallSamples.bat "Samples\ICS8.18" "ICS8.18_Destination"
::      Then folder ICS8.18 is copied to "%DEMOSDIR%\ICS8.18_Destination"

@IF NOT "%DEMOSDIR%"=="" (
	@mkdir %DEMOSDIR%\%2
	@xcopy %1 %DEMOSDIR%\%2 /E /R /Y /C >> null
)

