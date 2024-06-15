#include <bits/stdc++.h>
using namespace std;
 
/*int gcd(int a,int b){
     if (a == 0)
         return b;
     return gcd(b % a, a); 
}*/
int val(string s){
	int ans=0;
	for (int i=0;i<s.size();i++){
		ans+=(s[i]-'0');
	}
	return ans;
}
 
void solve(){
	int n;
	cin>>n;
	string arr[n];
	for (int i=0;i<n;i++)cin>>arr[i];
	long long ans=n;
    map <int,int> mpp1,mpp2,mpp3,mpp4,mpp5;
    for (int i=0;i<n;i++){
    	int val1=val(arr[i]);
    	if (arr[i].size()==1){
    		mpp1[val1]++;
    	}
     	else if (arr[i].size()==2){
    		mpp2[val1]++;
    	}
    	else if (arr[i].size()==3){
    		mpp3[val1]++;
 
    	}
    	else if (arr[i].size()==4){
    		mpp4[val1]++;
    	}
    	else {
    		mpp5[val1]++;
    	}
    }
    for (auto it:mpp1){
    	if (it.second>1)ans+=(long long)it.second*(long long)(it.second-1);
    }
    for (auto it:mpp2){
    	if (it.second>1)ans+=(long long)it.second*(long long)(it.second-1);
    }
     for (auto it:mpp3){
    	if (it.second>1)ans+=(long long)it.second*(long long)(it.second-1);
    }
    for (auto it:mpp4){
    	if (it.second>1)ans+=(long long)it.second*(long long)(it.second-1);
    }
    for (auto it:mpp5){
    	if (it.second>1)ans+=(long long)it.second*(long long)(it.second-1);
    }
    for (int i=0;i<n;i++){
    	int val1=val(arr[i]);
    	if (arr[i].size()==3){
    		int ele=val1-2*(arr[i][2]-'0'),ele2=val1-2*(arr[i][0]-'0');
    		if (mpp1.find(ele)!=mpp1.end())ans+=(long long)mpp1[ele];
    		if (mpp1.find(ele2)!=mpp1.end())ans+=(long long )mpp1[ele2];
    	}
    	else if(arr[i].size()==4){
    		int ele=val1-2*(arr[i][3]-'0'),ele2=val1-2*(arr[i][0]-'0');
    		if (mpp2.find(ele)!=mpp2.end())ans+=(long long)mpp2[ele];
    		if (mpp2.find(ele2)!=mpp2.end())ans+=(long long)mpp2[ele2];
    	}
    	else if(arr[i].size()==5){
    		int ele=val1-2*(arr[i][4]-'0'),ele2=val1-2*(arr[i][0]-'0');
    		if (mpp3.find(ele)!=mpp3.end())ans+=(long long )mpp3[ele];
    		if (mpp3.find(ele2)!=mpp3.end())ans+=(long long)mpp3[ele2];
    		int ele3=val1-2*((arr[i][4]-'0')+(arr[i][3]-'0')),ele4=val1-2*((arr[i][0]-'0')+(arr[i][1]-'0'));
    		if (mpp1.find(ele3)!=mpp1.end())ans+=(long long)mpp1[ele3];
    		if (mpp1.find(ele4)!=mpp1.end())ans+=(long long)mpp1[ele4];
    	}
    }
    cout<<ans<<endl;
}
 
 
int main(){
	ios::sync_with_stdio(false);cin.tie(NULL);
	int t=1;
	//cin>>t;
	while (t--){
		solve();
	}
}
