package control.salesSystem.salesManAspect.LookupAvailableProduct;

import java.awt.event.ActionEvent;

import control.DynamicSystem;
import control.salesSystem.SalesSystem;
import control.salesSystem.salesManAspect.SigninCustomer.SinginCustomerSystem;
import control.salesSystem.salesManAspect.WatchActivityPlan.WatchActivityPlanSystem;
import control.salesSystem.salesManAspect.WatchSalesTrainingPlan.WatchSalesTrainingPlanSystem;
import model.data.customerData.CustomerData;
import view.insuranceSystemView.salesView.salesMan.LookupAvailableProduct.ShowAvailableProductView;
import view.panel.BasicPanel;

public class ShowAvailableProductSystem extends SalesSystem {
	
	// Association
	private CustomerData customerData;
	
	// Constructor
	public ShowAvailableProductSystem(CustomerData customerData) {this.customerData = customerData;}
	
	@Override
	public BasicPanel getView() {return new ShowAvailableProductView(this.actionListener, this.insuranceDataList, this.customerData);}

	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		if(Character.isDigit(e.getActionCommand().charAt(0)))return new ShowInsuranceInfoToCustomerSystem(Integer.parseInt(e.getActionCommand()), this.customerData);
		switch (ShowAvailableProductView.EActionCommands.valueOf(e.getActionCommand())) {
		case SigninCustomer : return new SinginCustomerSystem();
		case LookupAvailableProduct : return new SearchCustomerSystem();
		case WatchActivityPlan: return new WatchActivityPlanSystem();
		case WatchSalesTrainingPlan: return new WatchSalesTrainingPlanSystem(); 
		}
		return null;
	}
}
