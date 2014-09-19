#!/bin/bash

export JAVA_HOME=/opt/jdk1.6.0
export NUTCH_HOME=/home/fbarth/nutch-0.7/nutch-0.7

export PATH=$JAVA_HOME/bin:$NUTCH_HOME/bin:$PATH

cd /home/fbarth/eclipse/workspace/BuscaInteligente-ObtemNoticias/

export CLASSPATH=classes/:$CLASSPATH

echo Excluindo diretorio antigo
rm -rf crawler/data-crawl-noticias

date >> metaInformacoes.txt
echo >> metaInformacoes.txt

echo Acessando as noticias do Estadao
java fontes.estadao.ObtemNoticiasEstadao fontesRssEstadao.txt nutchEstadao.txt crawler/tabelaEstadao.txt /home/fbarth/eclipse/workspace/BuscaInteligente-ObtemNoticias/resultadosEstadao/

echo Acessando as noticias da Folha
java fontes.folha.ObtemNoticiasFolha fontesRssFolha.txt nutchFolha.txt crawler/tabelaFolha.txt /home/fbarth/eclipse/workspace/BuscaInteligente-ObtemNoticias/resultadosFolha/

echo Acessando as noticias do g1.globo.com
java fontes.g1.ObtemNoticiasG1 fontesRssG1.txt nutchG1.txt crawler/tabelaG1.txt /home/fbarth/eclipse/workspace/BuscaInteligente-ObtemNoticias/resultadosG1/

echo Acessando as noticias do Globo Online
java fontes.globoOnline.ObtemNoticiasGloboOnline fontesRssGloboOnline.txt nutchGloboOnline.txt crawler/tabelaGloboOnline.txt /home/fbarth/eclipse/workspace/BuscaInteligente-ObtemNoticias/resultadosGloboOnline/

echo Acessando as noticias da Terra
java fontes.terra.ObtemNoticiasTerra fontesRssTerra.txt nutchTerra.txt crawler/tabelaTerra.txt /home/fbarth/eclipse/workspace/BuscaInteligente-ObtemNoticias/resultadosTerra/

echo Acessando as noticias do IG - Ultimo Segundo
java fontes.ultimoSegundo.ObtemNoticiasUltimoSegundo fontesRssUltimoSegundo.txt nutchUltimoSegundo.txt crawler/tabelaUltimoSegundo.txt /home/fbarth/eclipse/workspace/BuscaInteligente-ObtemNoticias/resultadosUltimoSegundo/

cat nutchEstadao.txt nutchFolha.txt nutchG1.txt nutchGloboOnline.txt nutchTerra.txt nutchUltimoSegundo.txt > nutchTodos.txt

cat crawler/tabelaEstadao.txt crawler/tabelaFolha.txt crawler/tabelaG1.txt crawler/tabelaGloboOnline.txt crawler/tabelaTerra.txt crawler/tabelaUltimoSegundo.txt > crawler/tabelaTodos.txt

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
echo >> metaInformacoes.txt