/*    */ package de.hybris.platform.customerreview.impl;
/*    */
/*    */ import de.hybris.platform.core.model.c2l.LanguageModel;
/*    */ import de.hybris.platform.core.model.product.ProductModel;
/*    */ import de.hybris.platform.core.model.user.UserModel;
/*    */ import de.hybris.platform.customerreview.CustomerReviewService;
/*    */ import de.hybris.platform.customerreview.dao.CustomerReviewDao;
/*    */ import de.hybris.platform.customerreview.jalo.CustomerReview;
/*    */ import de.hybris.platform.customerreview.jalo.CustomerReviewManager;
/*    */ import de.hybris.platform.customerreview.model.CustomerReviewModel;
/*    */ import de.hybris.platform.jalo.product.Product;
/*    */ import de.hybris.platform.jalo.user.User;
/*    */ import de.hybris.platform.servicelayer.internal.service.AbstractBusinessService;
/*    */ import de.hybris.platform.servicelayer.model.ModelService;
/*    */ import de.hybris.platform.servicelayer.util.ServicesUtil;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Required;
/*    */ import de.hybris.platform.customerreview.Exception.CustomException;
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
/*    */ public class DefaultCustomerReviewService
/*    */   extends AbstractBusinessService
/*    */   implements CustomerReviewService
/*    */ {
/*    */   private CustomerReviewDao customerReviewDao;
           private ValidateCustomerReviewService validateCustomerReview;
/*    */
/*    */   protected CustomerReviewDao getCustomerReviewDao()
/*    */   {
/* 41 */     return this.customerReviewDao;
/*    */   }
/*    */
/*    */   @Required
/*    */   public void setCustomerReviewDao(ValidateCustomerReviewService validateCustomerReview)
/*    */   {
/* 47 */     this.customerReviewDao = customerReviewDao;
/*    */   }
/*    */
          protected CustomerReviewDao getvalidateCustomerReview()
/*    */   {
/* 41 */     return this.validateCustomerReview;
/*    */   }
/*    */
/*    */   @Required
/*    */   public void setvalidateCustomerReview(ValidateCustomerReviewService validateCustomerReview)
/*    */   {
/* 47 */     this.validateCustomerReview = validateCustomerReview;
/*    */   }
/*    */
/*    */
/*    */   /*Validate whether the rating is valid and customer comment doesn't contain any curse word before adding new Customer Review  to the database*/
/*    */   public CustomerReviewModel createCustomerReview(Double rating, String headline, String comment, UserModel user, ProductModel product) throws CustomExceptionn
/*    */   {
             try
             {
             boolean result=getvalidateCustomerReview().checkCustomerReview(comment,rating);
             }catch(CustomException e){
              e.printStackTrace();
             }
             if(result==true){
/* 54 */     CustomerReview review = CustomerReviewManager.getInstance().createCustomerReview(rating, headline, comment,
/* 55 */       (User)getModelService().getSource(user), (Product)getModelService().getSource(product));
/* 56 */     return (CustomerReviewModel)getModelService().get(review);
            }
/*    */   }
/*    */
/*    */  
           /*Validate whether the rating is valid and customer comment doesn't contain any curse word before updating new Customer Review  to the database*/
/*    */   public void updateCustomerReview(CustomerReviewModel model, UserModel user, ProductModel product)
/*    */   {

              try
              {
                boolean result=getvalidateCustomerReview().checkCustomerReview(model.getComment(),model.getRating());
              }catch(CustomException e){
                e.printStackTrace();
              }
              if(result==true){
/* 62 */     model.setProduct(product);
/* 63 */     model.setUser(user);
/* 64 */     getModelService().save(model);
              }
/*    */   }
/*    */
/*    */
/*    */   public List<CustomerReviewModel> getAllReviews(ProductModel product)
/*    */   {
/* 70 */     List<CustomerReview> reviews = CustomerReviewManager.getInstance().getAllReviews(
/* 71 */       (Product)getModelService().getSource(product));
/* 72 */     return (List)getModelService().getAll(reviews, new ArrayList());
/*    */   }
/*    */
/*    */
/*    */   public Double getAverageRating(ProductModel product)
/*    */   {
/* 78 */     return CustomerReviewManager.getInstance().getAverageRating((Product)getModelService().getSource(product));
/*    */   }
/*    */
/*    */
/*    */   public Integer getNumberOfReviews(ProductModel product)
/*    */   {
/* 84 */     return CustomerReviewManager.getInstance().getNumberOfReviews((Product)getModelService().getSource(product));
/*    */   }
/*    */
/*    */
/*    */   public List<CustomerReviewModel> getReviewsForProduct(ProductModel product)
/*    */   {
/* 90 */     ServicesUtil.validateParameterNotNullStandardMessage("product", product);
/* 91 */     return getCustomerReviewDao().getReviewsForProduct(product);
/*    */   }
/*    */
/*    */
/*    */   public List<CustomerReviewModel> getReviewsForProductAndLanguage(ProductModel product, LanguageModel language)
/*    */   {
/* 97 */     ServicesUtil.validateParameterNotNullStandardMessage("product", product);
/* 98 */     ServicesUtil.validateParameterNotNullStandardMessage("language", language);
/* 99 */     return getCustomerReviewDao().getReviewsForProductAndLanguage(product, language);
/*    */   }

            /*Validate whether the parameter's given by the customer is not null for the search criteria */
/*    */    public int  getTotalCustomerReviewsForProduct(ProductModel product,Double range1,Double range2)
/*    */   {
/* 104 */     ServicesUtil.validateParameterNotNullStandardMessage("product", product);
/* 105*/      ServicesUtil.validateParameterNotNullStandardMessage("range1", range1);
/* 106*/      ServicesUtil.validateParameterNotNullStandardMessage("range2", range2);
/* 107 */     return getCustomerReviewDao().getReviewsForProductAndLanguage(product, range);
/*    */   }

/*    */ }


/* Location:              /Users/TJL4646/CustomerReview_Assignment/customerreviewserver.jar!/de/hybris/platform/customerreview/impl/DefaultCustomerReviewService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */
