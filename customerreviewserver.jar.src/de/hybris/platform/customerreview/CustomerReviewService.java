package de.hybris.platform.customerreview;

import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.customerreview.model.CustomerReviewModel;
import java.util.List;
import de.hybris.platform.customerreview.Exception.CustomException;

public abstract interface CustomerReviewService
{
  public abstract CustomerReviewModel createCustomerReview(Double paramDouble, String paramString1, String paramString2, UserModel paramUserModel, ProductModel paramProductModel) throws CustomException;

  public abstract void updateCustomerReview(CustomerReviewModel paramCustomerReviewModel, UserModel paramUserModel, ProductModel paramProductModel);

  public abstract List<CustomerReviewModel> getAllReviews(ProductModel paramProductModel);

  public abstract Double getAverageRating(ProductModel paramProductModel);

  public abstract Integer getNumberOfReviews(ProductModel paramProductModel);

  public abstract List<CustomerReviewModel> getReviewsForProduct(ProductModel paramProductModel);

  public abstract List<CustomerReviewModel> getReviewsForProductAndLanguage(ProductModel paramProductModel, LanguageModel paramLanguageModel);

  public abstract List<CustomerReviewModel>  getTotalCustomerReviewsForProduct(ProductModel paramProductModel,Double paramRange1,Double paramRange2);
}


/* Location:              /Users/TJL4646/CustomerReview_Assignment/customerreviewserver.jar!/de/hybris/platform/customerreview/CustomerReviewService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */
