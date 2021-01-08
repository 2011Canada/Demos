import { Customer } from "./Customer"
import { PurchaseHistoryLine } from "./PurchaseHistoryLine"

export class PurchaseHistory {
    purchaseHistoryId: number
    purchaser: Customer
    totalPurchase: PurchaseHistoryLine[]
}