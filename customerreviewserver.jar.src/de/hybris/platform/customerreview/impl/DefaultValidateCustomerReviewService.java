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
         import de.hybris.platform.customerreview.Exception.CustomException;

/*    */ public class DefaultValidateCustomerReviewService
/*    */   extends AbstractBusinessService
/*    */   implements ValidateCustomerReviewService
/*    */ {

         /*Check whether the comment does not contains any curse word which are mentioned in the file and also validate whether the rating is greater than zero */
          public boolean checkCustomerReview (String comment,Double rating)
          {
           boolean result=true;
           LinkedList<String> cursedWordList=DefaultValidateCustomerReviewService.getCursedWordList();
           String[] searchArray = comment.split("\\s");

           if(rating<=0)  /* Check for rating */
           {
             result=false;
             throw new CustomException("Rating should not be less than or equal to zero");
           }

          /*Validation for curse words*/
           forEach(String searchStr:searchArray){
             if(cursedWordList.stream().filter(s -> s.equalsIgnoreCase(searchStr)).findFirst().isPresent()))
             {
                  result=false;
                  throw new CustomException("Comments should not contain Harsh Words");
             }

           }

            return result;

          }
		  
		  /* Retrieve the curse word from the file as LinkedList*/

           public static LinkedList<String> getCursedWordList()
           {
             Scanner s = new Scanner(new File("filepath"));
             LinkedList<String> cursedWordList = new LinkedList<String>();
             while (s.hasNext()){
             list.add(s.next());
            }
            s.close();
            return cursedWordList;
           }


         }
