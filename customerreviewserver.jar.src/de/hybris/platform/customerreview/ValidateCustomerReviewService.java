package de.hybris.platform.customerreview;

import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.customerreview.model.CustomerReviewModel;
import java.util.List;


/* Creating a Abstract interface to validate Customer Review before submitting the review to the database */
 

public abstract interface ValidateCustomerReviewService
{

public abstract LinkedList<String> getCursedWordList();

public abstract boolean checkCustomerReview (String comment,Double rating);


}
