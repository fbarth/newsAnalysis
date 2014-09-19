#!/bin/bash

export LANG=pt_BR.ISO8859-1
export LANGUAGE=pt_BR:pt:pt_PT
export JAVA_HOME=/opt/jdk1.6.0_11
export NUTCH_HOME=/home/fabricio/atech2007/demonstracao/ariadne/nutch-0.7/nutch-0.7

export PATH=$JAVA_HOME/bin:$NUTCH_HOME/bin:$PATH

export DIR=/home/fabricio/eclipse/workspace/BuscaInteligente-ObtemNoticias

cd $DIR

export CLASSPATH=$DIR/classes/

echo Excluindo diretorio antigo
rm -rf crawler/data-crawl-noticias

date >> metaInformacoes.txt
echo >> metaInformacoes.txt

echo Acessando as noticias do Estadao
java fontes.estadao.ObtemNoticiasEstadao fontesRssEstadao.txt nutchEstadao.txt crawler/tabelaEstadao.txt $DIR/resultadosEstadao/

echo Acessando as noticias da Folha
java fontes.folha.ObtemNoticiasFolha fontesRssFolha.txt nutchFolha.txt crawler/tabelaFolha.txt $DIR/resultadosFolha/

echo Acessando as noticias do g1.globo.com
java fontes.g1.ObtemNoticiasG1 fontesRssG1.txt nutchG1.txt crawler/tabelaG1.txt $DIR/resultadosG1/

echo Acessando as noticias do Globo Online
java fontes.globoOnline.ObtemNoticiasGloboOnline fontesRssGloboOnline.txt nutchGloboOnline.txt crawler/tabelaGloboOnline.txt $DIR/resultadosGloboOnline/

echo Acessando as noticias da Terra
java fontes.terra.ObtemNoticiasTerra fontesRssTerra.txt nutchTerra.txt crawler/tabelaTerra.txt $DIR/resultadosTerra/

echo Acessando as noticias do IG - Ultimo Segundo
java fontes.ultimoSegundo.ObtemNoticiasUltimoSegundo fontesRssUltimoSegundo.txt nutchUltimoSegundo.txt crawler/tabelaUltimoSegundo.txt $DIR/resultadosUltimoSegundo/

echo Acessando as noticias do O Dia
java fontes.odia.ObtemNoticiasOdia fontesRssOdia.txt nutchOdia.txt crawler/tabelaOdia.txt $DIR/resultadosOdia/

echo Acessando as noticias do Diario Catarinense
java fontes.diarioCatarinense.ObtemNoticiasDiarioCatarinense fontesRssDiarioCatarinense.txt nutchDiarioCatarinense.txt crawler/tabelaDiarioCatarinense.txt $DIR/resultadosDiarioCatarinense/

echo Acessando as noticias do Correio do Brasil
java fontes.correioBrasil.ObtemNoticiasCorreioBrasil fontesRssCorreioBrasil.txt nutchCorreioBrasil.txt crawler/tabelaCorreioBrasil.txt $DIR/resultadosCorreioBrasil/

# Acessando alguns blogs

echo Acessando o blog do Claudio Humberto
java fontes.blogClaudioHumberto.ObtemNoticiasBlogClaudioHumberto fontesRssClaudioHumberto.txt nutchClaudioHumberto.txt crawler/tabelaClaudioHumberto.txt $DIR/resultadosClaudioHumberto/

echo Acessando o blog do Ancelmo Gois
java fontes.blogAncelmo.ObtemNoticiasBlogAncelmo fontesRssAncelmoGois.txt nutchAncelmoGois.txt crawler/tabelaAncelmoGois.txt $DIR/resultadosAncelmoGois/

#echo Acessando as noticias de Fontes nao trabalhadas - genericas
#java fontes.generico.ObtemNoticiasGenericas fontesRssGenericas.txt nutchGenericas.txt crawler/tabelaGenericas.txt $DIR/resultadosGenericas/

#cat nutchEstadao.txt nutchFolha.txt nutchG1.txt nutchGloboOnline.txt nutchTerra.txt nutchUltimoSegundo.txt nutchOdia.txt nutchDiarioCatarinense.txt nutchCorreioBrasil.txt nutchGenericas.txt > nutchTodos.txt

cat nutchEstadao.txt nutchFolha.txt nutchG1.txt nutchGloboOnline.txt nutchTerra.txt nutchUltimoSegundo.txt nutchOdia.txt nutchDiarioCatarinense.txt nutchCorreioBrasil.txt nutchClaudioHumberto.txt nutchAncelmoGois.txt > nutchTodos.txt

#cat crawler/tabelaEstadao.txt crawler/tabelaFolha.txt crawler/tabelaG1.txt crawler/tabelaGloboOnline.txt crawler/tabelaTerra.txt crawler/tabelaUltimoSegundo.txt crawler/tabelaOdia.txt crawler/tabelaDiarioCatarinense.txt crawler/tabelaCorreioBrasil.txt crawler/tabelaGenericas.txt > crawler/tabelaTodos.txt

cat crawler/tabelaEstadao.txt crawler/tabelaFolha.txt crawler/tabelaG1.txt crawler/tabelaGloboOnline.txt crawler/tabelaTerra.txt crawler/tabelaUltimoSegundo.txt crawler/tabelaOdia.txt crawler/tabelaDiarioCatarinense.txt crawler/tabelaCorreioBrasil.txt crawler/tabelaClaudioHumberto.txt crawler/tabelaAncelmoGois.txt > crawler/tabelaTodos.txt

echo Indexando as fontes de informacao
nutch crawl nutchTodos.txt -dir crawler/data-crawl-noticias

echo Coletando informacoes adicionais
date >> metaInformacoes.txt
echo >> metaInformacoes.txt
wc nutchEstadao.txt >> metaInformacoes.txt
echo >> metaInformacoes.txt
wc nutchFolha.txt >> metaInformacoes.txt
echo >> metaInformacoes.txt
wc nutchG1.txt >> metaInformacoes.txt
echo >> metaInformacoes.txt
wc nutchGloboOnline.txt >> metaInformacoes.txt
echo >> metaInformacoes.txt
wc nutchTerra.txt >> metaInformacoes.txt
echo >> metaInformacoes.txt
wc nutchUltimoSegundo.txt >> metaInformacoes.txt
echo >> metaInformacoes.txt
wc nutchOdia.txt >> metaInformacoes.txt
echo >> metaInformacoes.txt
wc nutchDiarioCatarinense.txt >> metaInformacoes.txt
echo >> metaInformacoes.txt
wc nutchCorreioBrasil.txt >> metaInformacoes.txt
echo >> metaInformacoes.txt
#wc nutchGenericas.txt >> metaInformacoes.txt
#echo >> metaInformacoes.txt
wc nutchClaudioHumberto.txt >> metaInformacoes.txt
echo >> metaInformacoes.txt
wc nutchAncelmoGois.txt >> metaInformacoes.txt
echo >> metaInformacoes.txt
echo >> metaInformacoes.txt