#!/bin/bash

export JAVA_HOME=/opt/jdk1.6.0_11
export NUTCH_HOME=/home/fabricio/atech2007/demonstracao/ariadne/nutch-0.7/nutch-0.7

export PATH=$JAVA_HOME/bin:$NUTCH_HOME/bin:$PATH

export DIR=/home/fabricio/eclipse/workspace/BuscaInteligente-ObtemNoticias

cd $DIR

export CLASSPATH=$DIR/classes/

echo Excluindo diretorio antigo
rm -rf crawler/data-crawl-blogs

date >> metaInformacoesBlogs.txt
echo >> metaInformacoesBlogs.txt

echo Acessando o blog do Claudio Humberto
java fontes.blogClaudioHumberto.ObtemNoticiasBlogClaudioHumberto fontesRssClaudioHumberto.txt nutchClaudioHumberto.txt crawler/tabelaClaudioHumberto.txt $DIR/resultadosClaudioHumberto/

echo Acessando o blog do Ancelmo Gois
java fontes.blogAncelmo.ObtemNoticiasBlogAncelmo fontesRssAncelmoGois.txt nutchAncelmoGois.txt crawler/tabelaAncelmoGois.txt $DIR/resultadosAncelmoGois/

cat nutchClaudioHumberto.txt nutchAncelmoGois.txt > nutchTodosBlogs.txt

cat crawler/tabelaClaudioHumberto.txt crawler/tabelaAncelmoGois.txt > crawler/tabelaTodosBlogs.txt

echo Indexando as fontes de informacao
nutch crawl nutchTodosBlogs.txt -dir crawler/data-crawl-blogs

echo Coletando informacoes adicionais
date >> metaInformacoesBlogs.txt
echo >> metaInformacoesBlogs.txt
wc nutchClaudioHumberto.txt >> metaInformacoesBlogs.txt
echo >> metaInformacoesBlogs.txt
wc nutchAncelmoGois.txt >> metaInformacoesBlogs.txt
echo >> metaInformacoesBlogs.txt
echo >> metaInformacoes.txt