/*    */ package de.hybris.platform.customerreview.dao.impl;
/*    */
/*    */ import de.hybris.platform.core.model.c2l.LanguageModel;
/*    */ import de.hybris.platform.core.model.product.ProductModel;
/*    */ import de.hybris.platform.customerreview.dao.CustomerReviewDao;
/*    */ import de.hybris.platform.customerreview.model.CustomerReviewModel;
/*    */ import de.hybris.platform.jalo.Item;
/*    */ import de.hybris.platform.servicelayer.internal.dao.AbstractItemDao;
/*    */ import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
/*    */ import de.hybris.platform.servicelayer.search.FlexibleSearchService;
/*    */ import de.hybris.platform.servicelayer.search.SearchResult;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */ public class DefaultCustomerReviewDao
/*    */   extends AbstractItemDao
/*    */   implements CustomerReviewDao
/*    */ {
/*    */   public List<CustomerReviewModel> getReviewsForProduct(ProductModel product)
/*    */   {
/* 36 */     String query = "SELECT {" + Item.PK + "} FROM {" + "CustomerReview" + "} WHERE {" + "product" + "}=?product ORDER BY {" + "creationtime" + "} DESC";
/* 37 */     FlexibleSearchQuery fsQuery = new FlexibleSearchQuery(query);
/* 38 */     fsQuery.addQueryParameter("product", product);
/* 39 */     fsQuery.setResultClassList(Collections.singletonList(CustomerReviewModel.class));
/*    */
/* 41 */     SearchResult<CustomerReviewModel> searchResult = getFlexibleSearchService().search(fsQuery);
/* 42 */     return searchResult.getResult();
/*    */   }
/*    */
/*    */
/*    */   public List<CustomerReviewModel> getReviewsForProductAndLanguage(ProductModel product, LanguageModel language)
/*    */   {
/* 48 */     String query = "SELECT {" + Item.PK + "} FROM {" + "CustomerReview" + "} WHERE {" + "product" + "}=?product AND {" + "language" + "}=?language ORDER BY {" + "creationtime" + "} DESC";
/* 49 */     FlexibleSearchQuery fsQuery = new FlexibleSearchQuery(query);
/* 50 */     fsQuery.addQueryParameter("product", product);
/* 51 */     fsQuery.addQueryParameter("language", language);
/* 52 */     fsQuery.setResultClassList(Collections.singletonList(CustomerReviewModel.class));
/*    */
/* 54 */     SearchResult<CustomerReviewModel> searchResult = getFlexibleSearchService().search(fsQuery);
/* 55 */     return searchResult.getResult();
/*    */   }
/*    */ }
           /*Retrieve the total count custoemr reviews from the database for a given product within the given range of ratings */
            public int getTotalCustomerReviewsForProduct(ProductModel product,Double range1,Double range2)
/*    */   {
/* 61 */     "SELECT {" + Item.PK + "} FROM {" + "CustomerReview" + "} WHERE {" + "product" + "}=?product and { " +"rating" +"} BETWEEN ?range1 and ?range2 ORDER BY {" +    "creationtime" + "} DESC";
/* 63 */     FlexibleSearchQuery fsQuery = new FlexibleSearchQuery(query);
/* 64 */     fsQuery.addQueryParameter("product", product);
             fsQuery.addQueryParameter("range1",range1);
             fsQuery.addQueryParameter("range2",range2);
/* 67 */     fsQuery.setResultClassList(Collections.singletonList(CustomerReviewModel.class));
/*    */
/* 69 */     SearchResult<CustomerReviewModel> searchResult = getFlexibleSearchService().search(fsQuery);
/* 70 */     List<CustomerReviewModel> result= searchResult.getResult();
             return result.size();
/*    */   }



/* Location:              /Users/TJL4646/CustomerReview_Assignment/customerreviewserver.jar!/de/hybris/platform/customerreview/dao/impl/DefaultCustomerReviewDao.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */
