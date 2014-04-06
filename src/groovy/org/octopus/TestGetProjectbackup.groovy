package org.octopus
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


def doc = Jsoup.connect("http://www.ncbi.nlm.nih.gov/gds")
.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
.header("Accept-Encoding", "gzip,deflate,sdch")
.header("Accept-Language", "ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4")
.userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.117 Safari/537.36")
.data("term","ChIP-seq mouse")
.data("EntrezSystem2.PEntrez.Gds.Entrez_PageController.PreviousPageName","results")
.data("EntrezSystem2.PEntrez.Gds.Gds_Facets.FacetsUrlFrag","filters=samplesGds")
.data("EntrezSystem2.PEntrez.Gds.Gds_Facets.FacetSubmitted","false")
.data("EntrezSystem2.PEntrez.Gds.Gds_Facets.BMFacets","")
.data("EntrezSystem2.PEntrez.Gds.Gds_ResultsPanel.Gds_DisplayBar.sPresentation","docsum")
.data("EntrezSystem2.PEntrez.Gds.Gds_ResultsPanel.Gds_DisplayBar.sPageSize","20")
.data("EntrezSystem2.PEntrez.Gds.Gds_ResultsPanel.Gds_DisplayBar.sSort","none")
.data("EntrezSystem2.PEntrez.Gds.Gds_ResultsPanel.Gds_DisplayBar.FFormat","docsum")
.data("EntrezSystem2.PEntrez.Gds.Gds_ResultsPanel.Gds_DisplayBar.FSort","")
.data("EntrezSystem2.PEntrez.Gds.Gds_ResultsPanel.Gds_DisplayBar.FileFormat","docsum")
.data("EntrezSystem2.PEntrez.Gds.Gds_ResultsPanel.Gds_DisplayBar.LastPresentation","docsum")
.data("EntrezSystem2.PEntrez.Gds.Gds_ResultsPanel.Gds_DisplayBar.Presentation","docsum")
.data("EntrezSystem2.PEntrez.Gds.Gds_ResultsPanel.Gds_DisplayBar.PageSize","20")
.data("EntrezSystem2.PEntrez.Gds.Gds_ResultsPanel.Gds_DisplayBar.Sort","none")
.data("EntrezSystem2.PEntrez.Gds.Gds_ResultsPanel.Gds_DisplayBar.LastSort","")
.data("EntrezSystem2.PEntrez.Gds.Gds_ResultsPanel.Gds_DisplayBar.FileSort","")
.data("EntrezSystem2.PEntrez.Gds.Gds_ResultsPanel.Gds_DisplayBar.Format","text")
.data("EntrezSystem2.PEntrez.Gds.Gds_ResultsPanel.Gds_DisplayBar.LastFormat","")
.data("EntrezSystem2.PEntrez.Gds.Gds_ResultsPanel.Entrez_Pager.cPage","1")
.data("EntrezSystem2.PEntrez.Gds.Gds_ResultsPanel.Entrez_Pager.CurrPage","1")
.data("EntrezSystem2.PEntrez.Gds.Gds_ResultsPanel.Gds_ResultsController.ResultCount","2174")
.data("EntrezSystem2.PEntrez.Gds.Gds_ResultsPanel.Gds_ResultsController.RunLastQuery","")
.data("EntrezSystem2.PEntrez.Gds.Gds_ResultsPanel.Entrez_Pager.cPage","1")



.data("EntrezSystem2.PEntrez.Gds.Gds_ResultsPanel.Gds_DisplayBar.sPresentation2","docsum")
.data("EntrezSystem2.PEntrez.Gds.Gds_ResultsPanel.Gds_DisplayBar.sPageSize2","20")
.data("EntrezSystem2.PEntrez.Gds.Gds_ResultsPanel.Gds_DisplayBar.sSort2","none")
.data("EntrezSystem2.PEntrez.Gds.Gds_ResultsPanel.Gds_DisplayBar.FFormat2","docsum")
.data("EntrezSystem2.PEntrez.Gds.Gds_ResultsPanel.Gds_DisplayBar.FSort2","")
.data("EntrezSystem2.PEntrez.Gds.Gds_ResultsPanel.Gds_MultiItemSupl.Taxport.TxView","list")
.data("EntrezSystem2.PEntrez.Gds.Gds_ResultsPanel.Gds_MultiItemSupl.Taxport.TxListSize","5")
.data("EntrezSystem2.PEntrez.Gds.Gds_ResultsPanel.Gds_MultiItemSupl.RelatedDataLinks.rdDatabase","rddbto")
.data("EntrezSystem2.PEntrez.Gds.Gds_ResultsPanel.Gds_MultiItemSupl.RelatedDataLinks.DbName","gds")
.data("EntrezSystem2.PEntrez.Gds.Gds_ResultsPanel.Discovery_SearchDetails.SearchDetailsTerm",'(ChIP-seq[All Fields] AND ("mice"[MeSH Terms] OR "Mus musculus"[Organism] OR mouse[All Fields])) AND "gsm"[Filter]')
.data("EntrezSystem2.PEntrez.Gds.Gds_ResultsPanel.HistoryDisplay.Cmd","displaychanged")
.data("EntrezSystem2.PEntrez.DbConnector.Db","gds")
.data("EntrezSystem2.PEntrez.DbConnector.LastDb","gds")
.data("EntrezSystem2.PEntrez.DbConnector.Term","ChIP-seq mouse")
.data("EntrezSystem2.PEntrez.DbConnector.LastTabCmd","")
.data("EntrezSystem2.PEntrez.DbConnector.LastQueryKey","2")
.data("EntrezSystem2.PEntrez.DbConnector.IdsFromResult","")
.data("EntrezSystem2.PEntrez.DbConnector.LastIdsFromResult","")
.data("EntrezSystem2.PEntrez.DbConnector.LinkName","")
.data("EntrezSystem2.PEntrez.DbConnector.LinkReadableName","")
.data("EntrezSystem2.PEntrez.DbConnector.LinkSrcDb","")
//.data("EntrezSystem2.PEntrez.DbConnector.Cmd","displaychanged")
.data("EntrezSystem2.PEntrez.DbConnector.TabCmd","")
.data("EntrezSystem2.PEntrez.DbConnector.QueryKey","")
.data('p$a',"EntrezSystem2.PEntrez.Gds.Gds_ResultsPanel.Gds_DisplayBar.SetDisplay")
.data('p$l',"EntrezSystem2")
.data('p$st',"gds")
.post();
def doc1 = Jsoup.connect("http://www.ncbi.nlm.nih.gov/gds/?term=ChIP-seq%20mouse").get();
String title = doc.title();
System.out.println(doc);


//Document doc1 = Jsoup.connect('http://www.ncbi.nlm.nih.gov/geo/query/acc.cgi?acc=GSE42810')
//.timeout(60000)
//.get();
//def aa = doc1.select("tr[valign=top] ");
//aa.each{
//	def children = it.children()
//	if(children.size() == 2){
//		children.eachWithIndex { oneResult,index->
//			if(index == 0){
//				println "title="+oneResult.text().trim()
//			}else{
//				println "contents="+oneResult.text().trim()
//			}
//		}
//	}
//}
//http://www.ncbi.nlm.nih.gov/geo/query/acc.cgi?acc=GSM1050349&targ=self&form=xml&view=quick


