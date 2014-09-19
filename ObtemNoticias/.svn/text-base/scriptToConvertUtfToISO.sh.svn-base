#!/bin/bash

echo "#!/bin/bash" > utf2iso.sh
echo "" >> utf2iso.sh
echo "" >> utf2iso.sh

ls resultadosEstadao/ | awk '{printf("iconv -f utf-8 -t iso-8859-1 resultadosEstadao/%s > resultadosEstadao-iso8859-1/%s\n",$0,$0)}' >> utf2iso.sh
ls resultadosFolha/ | awk '{printf("iconv -f utf-8 -t iso-8859-1 resultadosFolha/%s > resultadosFolha-iso8859-1/%s\n",$0,$0)}' >> utf2iso.sh
ls resultadosG1/ | awk '{printf("iconv -f utf-8 -t iso-8859-1 resultadosG1/%s > resultadosG1-iso8859-1/%s\n",$0,$0)}' >> utf2iso.sh
ls resultadosGloboOnline/ | awk '{printf("iconv -f utf-8 -t iso-8859-1 resultadosGloboOnline/%s > resultadosGloboOnline-iso8859-1/%s\n",$0,$0)}' >> utf2iso.sh
ls resultadosTerra/ | awk '{printf("iconv -f utf-8 -t iso-8859-1 resultadosTerra/%s > resultadosTerra-iso8859-1/%s\n",$0,$0)}' >> utf2iso.sh
ls resultadosUltimoSegundo/ | awk '{printf("iconv -f utf-8 -t iso-8859-1 resultadosUltimoSegundo/%s > resultadosUltimoSegundo-iso8859-1/%s\n",$0,$0)}' >> utf2iso.sh
