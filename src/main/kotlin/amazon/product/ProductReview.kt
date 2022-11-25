package amazon.product

import amazon.account.Member

data class ProductReview(val review: String, val rating: Int, val reviewer: Member)
