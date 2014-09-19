#!/bin/bash

echo "#!/bin/bash" > allToUtf.sh
echo "" >> allToUtf.sh
echo "" >> allToUtf.sh

ls resultadosEstadao/ | awk '{printf("iconv -t utf-8 resultadosEstadao/%s > resultadosEstadao-utf/%s\n",$0,$0)}' >> allToUtf.sh
ls resultadosFolha/ | awk '{printf("iconv -t utf-8 resultadosFolha/%s > resultadosFolha-utf/%s\n",$0,$0)}' >> allToUtf.sh
ls resultadosG1/ | awk '{printf("iconv -t utf-8 resultadosG1/%s > resultadosG1-utf/%s\n",$0,$0)}' >> allToUtf.sh
ls resultadosGloboOnline/ | awk '{printf("iconv -t utf-8 resultadosGloboOnline/%s > resultadosGloboOnline-utf/%s\n",$0,$0)}' >> allToUtf.sh
ls resultadosTerra/ | awk '{printf("iconv -t utf-8 resultadosTerra/%s > resultadosTerra-utf/%s\n",$0,$0)}' >> allToUtf.sh
ls resultadosUltimoSegundo/ | awk '{printf("iconv -t utf-8 resultadosUltimoSegundo/%s > resultadosUltimoSegundo-utf/%s\n",$0,$0)}' >> allToUtf.sh
