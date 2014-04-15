function allowActiveX() {
    
sRegHKCUIS      = 'HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings';
REG_DWORD       = 'REG_DWORD';

sRegDomains     = '\\ZoneMap\\Domains';    
sServer             = 'dark_comp';
sRegDomainsVar      = 'http';
sRegDomainsVarType  = REG_DWORD;
sRegDomainsVal      = '00000002';
sRegServerZone  = '\\Zones\\2';
sRegServerZoneVar       = 'CurrentLevel';
sRegServerZoneVarType   = REG_DWORD;
sRegServerZoneVal       = '00011000';

    try {
        var oShell = new ActiveXObject("WScript.Shell");
        oShell.RegWrite( sRegHKCUIS + sRegDomains + '\\', sServer );
        oShell.RegWrite( sRegHKCUIS + sRegDomains + '\\' + sServer + '\\' + sRegDomainsVar, sRegDomainsVal, sRegDomainsVarType );
        oShell.RegWrite( sRegHKCUIS + sRegServerZone + '\\' + sRegServerZoneVar, sRegServerZoneVal, sRegServerZoneVarType );
//        alert('ActiveX Success: Для применения парамметров необходимо перезапустить программу.');
        return true;
    } catch (e) {
        alert('ActiveX Error: Ошибка инициализации доверенной зоны.[1]');
        return false;
    }
}
function getPrinter() {
    GetDefaultPrinter = '';
    try {
        var oShell = new ActiveXObject("WScript.Shell");
        sRegVal = 'HKEY_CURRENT_USER\\Software\\Microsoft\\Windows NT\\CurrentVersion\\Windows\\Device';
        sDefault = "";
        sDefault = oShell.RegRead(sRegVal);
        GetDefaultPrinter = sDefault.split(',', 1);
        return GetDefaultPrinter;
    } catch (e) {
        alert('ActiveX Error: Ошибка инициализации проверки принтера.');
        return GetDefaultPrinter;
    }
}
